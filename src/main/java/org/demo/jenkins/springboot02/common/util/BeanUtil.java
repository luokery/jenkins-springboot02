package org.demo.jenkins.springboot02.common.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.demo.jenkins.springboot02.cosnst.BusinessEnum;
import org.demo.jenkins.springboot02.cosnst.UtilResultEnum;
import org.demo.jenkins.springboot02.exception.BusinessException;
import org.demo.jenkins.springboot02.exception.UtilsException;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * bean工具
 * 
 * @author jun
 */
public class BeanUtil {

	private static ObjectMapper objectMapper;

	public static BeanUtil getInstance() {
		return Singleton.INSTANCE.getInstance();
	}
	
	private BeanUtil() {
		objectMapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	/**
	 * 枚举单列模式
	 * @author jun
	 */
	private static enum Singleton {
	    INSTANCE;

	    private BeanUtil instance;

	    Singleton() {
	        this.instance = new BeanUtil();
	    }

	    public BeanUtil getInstance() {
	        return this.instance;
	    }
	}
	
	static {
		Singleton.INSTANCE.getInstance();
	}
	
	/**
	 * 属性拷贝工具
	 * 
	 * @param <T>
	 * @param dest
	 * @param orig
	 * @return
	 */
	public static <T> T copyPropertie(T dest, T orig) {
		return copyPropertie(dest, orig, BusinessEnum.DATA_COPY_ERROR.msg());
	}

	/**
	 * 属性拷贝工具, 带错误消息
	 * 
	 * @param <T>
	 * @param dest
	 * @param orig
	 * @param msg
	 * @return
	 */
	public static <T> T copyPropertie(T dest, T orig, String msg) {

		if (dest == null || orig == null) {
//			return BeanUtils.dest.getClass().newInstance();
			throw new BusinessException(BusinessEnum.DATA_COPY_ERROR.getCode(), msg);
		}
		try {

			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new BusinessException(BusinessEnum.DATA_COPY_ERROR);
		}
		return dest;
	}

	/**
	 * 属性拷贝工具
	 * 
	 * @param <T>
	 * @param dest
	 * @param orig
	 * @return
	 */
	public static void copyProperties(final Object dest, final Object orig) {

		copyProperties(dest, orig, BusinessEnum.DATA_COPY_ERROR.getMsg());
	}

	/**
	 * 属性拷贝工具, 带错误消息
	 * 
	 * @param <T>
	 * @param dest
	 * @param orig
	 * @param msg
	 * @return
	 */
	public static void copyProperties(final Object dest, final Object orig, String msg) {
		try {

			if (dest == null || orig == null) {
				throw new BusinessException(BusinessEnum.DATA_COPY_ERROR.getCode(), msg);
			}
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new BusinessException(BusinessEnum.DATA_COPY_ERROR);
		}
	}

	/**
	 * 把list中的对象转换(对象中不能有list对象)
	 * 
	 * <pre>
	 * List<UserBean> userBeans = userDao.queryUsers();
	 * List<UserDTO> userDTOs = BeanUtil.batchTransform(UserDTO.class, userBeans);
	 * </pre>
	 */
	public static <T> List<T> batchTransform(final Class<T> clazz, List<? extends Object> srcList) {
		if (CollectionUtils.isEmpty(srcList)) {
			return Collections.emptyList();
		}

		List<T> result = new ArrayList<>(srcList.size());
		for (Object srcObject : srcList) {
			result.add(transfrom(clazz, srcObject));
		}
		return result;
	}

	/**
	 * 封装{@link org.springframework.beans.BeanUtils#copyProperties}，惯用与直接将转换结果返回
	 *
	 * <pre>
	 * UserBean userBean = new UserBean("username");
	 * return BeanUtil.transform(UserDTO.class, userBean);
	 * </pre>
	 */
	public static <T> T transfrom(Class<T> clazz, Object src) {
		if (src == null) {
			return null;
		}
		T instance = null;
		try {
			instance = clazz.newInstance();
		} catch (Exception e) {
			throw new UtilsException(UtilResultEnum.SYSTEM_UTILS_ERROR);
		}
		org.springframework.beans.BeanUtils.copyProperties(src, instance, getNullPropertyNames(src));
		return instance;
	}

	private static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<String>();
		for (PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

	/**
	 * 根据列表里面的属性聚合
	 *
	 * <pre>
	 * List<ShopDTO> shopList = shopService.queryShops();
	 * Map<Integer, List<ShopDTO>> city2Shops = BeanUtil.aggByKeyToList("cityId", shopList);
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, List<V>> aggByKeyToList(String key, List<? extends Object> list) {
		Map<K, List<V>> map = new HashMap<K, List<V>>();
		// 防止外面传入空list
		if (CollectionUtils.isEmpty(list)) {
			return map;
		}
		try {
			Class<? extends Object> clazz = list.get(0).getClass();
			Field field = deepFindField(clazz, key);
			if (field == null)
				throw new IllegalArgumentException("Could not find the key");
			field.setAccessible(true);
			for (Object o : list) {
				K k = (K) field.get(o);
				if (map.get(k) == null) {
					map.put(k, new ArrayList<V>());
				}
				map.get(k).add((V) o);
			}
		} catch (Exception e) {
			throw new UtilsException(UtilResultEnum.SYSTEM_UTILS_ERROR);
		}
		return map;
	}

	/**
	 * 用于将一个对象的列表转换为列表中对象的属性集合
	 *
	 * <pre>
	 * List<UserDTO> userList = userService.queryUsers();
	 * Set<Integer> userIds = BeanUtil.toPropertySet("userId", userList);
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	public static <K> Set<K> toPropertySet(String key, List<? extends Object> list) {
		Set<K> set = new HashSet<K>();
		if (CollectionUtils.isEmpty(list)) {// 防止外面传入空list
			return set;
		}
		try {
			Class<? extends Object> clazz = list.get(0).getClass();
			Field field = deepFindField(clazz, key);
			if (field == null)
				throw new IllegalArgumentException("Could not find the key");
			field.setAccessible(true);
			for (Object o : list) {
				set.add((K) field.get(o));
			}
		} catch (Exception e) {
			throw new UtilsException(UtilResultEnum.SYSTEM_UTILS_ERROR);
		}
		return set;
	}

	private static Field deepFindField(Class<? extends Object> clazz, String key) {
		Field field = null;
		while (!clazz.getName().equals(Object.class.getName())) {
			try {
				field = clazz.getDeclaredField(key);
				if (field != null) {
					break;
				}
			} catch (Exception e) {
				clazz = clazz.getSuperclass();
			}
		}
		return field;
	}

	/**
	 * bean中带复杂属性： 如list， map， bean等
	 * 
	 * @param <T>
	 * @param clazz
	 * @param srcObj
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws JsonProcessingException
	 */
	public <T> T transformJson(final Class<T> clazz, Object srcObj)
			throws InstantiationException, IllegalAccessException, JsonProcessingException {
		if (ObjectUtils.isEmpty(srcObj)) {
			return clazz.newInstance();
		}
//		ObjectMapper objectMapper = new ObjectMapper();
		String jsonValue = objectMapper.writeValueAsString(srcObj);

		T result = objectMapper.readValue(jsonValue, clazz);

		return result;
	}

	public static <E> List<E> copyList( List<?> list, Class<E> clazz) throws JsonProcessingException {
		
		if (CollectionUtils.isEmpty(list)) {
			return new ArrayList<E>();
		}
//		ObjectMapper objectMapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		String jsonString = BeanUtil.objectMapper.writeValueAsString( list);
		return BeanUtil.objectMapper.readValue(jsonString, getCollectionType(list.getClass(), clazz));
	}
	/**
	 * 获取泛型的Collection Type
	 * 
	 * @param collectionClass 泛型的Collection
	 * @param elementClasses  实体bean
	 * @return JavaType Java类型
	 */
	private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return BeanUtil.objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}
}
