package spring.simple;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 想要实现简单的ioc只需四步
 * 1.加载xml文件，遍历其中的标签
 * 2.获取标签中 id 和 class 属性，加载 class 属性对应的类， 创建 bean
 * 3.遍历标签中的标签，获取属性值， 并将属性填充到bean中
 */
public class SimpleIoc {

    // 存放bean
    private Map<String, Object> beanMap = new HashMap<>();

    /**
     *
     * @param location
     */
    public SimpleIoc(String location) throws Exception {
        loadBeans(location);
    }

    /**
     * 通过name从已经创建好的bean中获取bean
     * @param name
     * @return
     */
    public Object getBean(String name){
        Object bean = beanMap.get(name);
        if(bean == null){
            throw new IllegalArgumentException("there is no bean with name: " + name);
        }
        return bean;
    }

    /**
     * 读取xml加载bean
     * @param location
     */
    public void loadBeans(String location) throws Exception{
        // 读取xml文件
        InputStream is  = new FileInputStream(location);

    }
}
