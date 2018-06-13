package com.seckawijoki.processor;

import com.seckawijoki.annotation.JavabeanPropertyMethod;

import java.beans.Introspector;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/31 at 16:05 under Windows-10 Professional.
 */
@SupportedAnnotationTypes("com.seckawijoki.annotation.JavabeanPropertyMethod")
@SupportedSourceVersion(SourceVersion.RELEASE_0)
@SuppressWarnings("")
@Deprecated
public class JavabeanPropertyMethodProcessor extends AbstractProcessor {
  private Messager messager;

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
    for ( TypeElement annotation : annotations ) {
      Map<String, JavabeanPropertyMethod> map = new LinkedHashMap<>();
      String beanClassName;
      for (Element e : roundEnvironment.getElementsAnnotatedWith(annotation)){
        String methodName = e.getSimpleName().toString();
        String[] prefixes = {"get", "set", "is"};
        boolean found = false;
        for ( int i = 0 ; !found && i < prefixes.length ; ++i ) {
          if (methodName.startsWith(prefixes[i])){
            found = true;
            int start = prefixes[i].length();
            String fieldName = Introspector.decapitalize(methodName.substring(start));
          }

        }
      }
    }
    return false;
  }

  @Override
  public Set<String> getSupportedAnnotationTypes() {
    return super.getSupportedAnnotationTypes();
  }

  @Override
  public SourceVersion getSupportedSourceVersion() {
    return super.getSupportedSourceVersion();
  }

  @Override
  public synchronized void init(ProcessingEnvironment processingEnvironment) {
    super.init(processingEnvironment);
    messager = processingEnvironment.getMessager();

    }
}
