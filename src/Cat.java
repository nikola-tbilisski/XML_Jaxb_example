import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Cat {
    @XmlElement(name = "catname")
    public String name;

    @XmlAttribute(name = "age")
    public int age;

    @XmlAttribute(name = "W")
    public int weight;

    public Cat(){}
}
