import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

public class Jaxb1 {
    public static void main(String[] args) throws JAXBException {
        //создание объектов Cat&Zoo для сериализации в XML
        Cat cat1 = new Cat();
        cat1.name = "Murka";
        cat1.age = 5;
        cat1.weight = 4;

        Cat cat2 = new Cat();
        cat2.name = "Tomy";
        cat2.age = 3;
        cat2.weight = 2;

        Zoo zoo = new Zoo();
        zoo.animals.add(cat1);
        zoo.animals.add(cat2);
        //zoo.animals.add(cat1);

        //писать результат сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(Cat.class, Zoo.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // самосериализация
        marshaller.marshal(zoo, writer);

        //преобразовываем все записанное в StringWriter в строку
        System.out.println(writer);

    }
}
