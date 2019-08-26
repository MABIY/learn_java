package annotations;


import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lh
 * APT-based annotation processing.
 * {Exec: apt -factory
 * annotations.InterfaceExtractorProcessorFactory
 * Multiplier.java -s ../annotations}
 */
@SupportedAnnotationTypes("annotations.ExtractInterface")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class InterfaceExtractorProcessor extends AbstractProcessor {
    private List<Method> interfaceMethods = new ArrayList<>();

    public static void main(String[] args) {

    }

    //返回注解处理器可处理的注解操作
    @Override
    public Set<String> getSupportedOptions() {
        return super.getSupportedOptions();
    }

    //得到注解处理器可以支持的注解类型
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> strings = new HashSet<>();
        strings.add("annotations.ExtractInterface");
        return strings;
    }

    //执行一些初始化逻辑
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> rootE = roundEnv.getRootElements();
        for (TypeElement typeDecl : annotations) {
            for (Element e : rootE) {
                for (Element subElement : e.getEnclosedElements()) {
                    System.out.println(subElement);
                    System.out.println(subElement.getKind());
                    System.out.println(subElement.getSimpleName());
                    System.out.println(subElement.asType());
                }
            }
        }
        return true;
    }

}
