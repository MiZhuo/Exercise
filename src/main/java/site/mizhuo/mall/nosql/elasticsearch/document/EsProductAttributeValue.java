package site.mizhuo.mall.nosql.elasticsearch.document;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author: Mizhuo
 * @time: 2021/1/14 8:57 下午
 * @description:
 */
public class EsProductAttributeValue implements Serializable {

    private static final long serialVersionUID = 359822515991520959L;

    private Long id;

    private Long productAttributeId;

    /**
     * 属性值
     */
    @Field(type = FieldType.Keyword)
    private String value;

    /**
     * 属性参数：0->规格；1->参数
     */
    private Integer type;

    /**
     * 属性名称
     */
    @Field(type=FieldType.Keyword)
    private String name;

}
