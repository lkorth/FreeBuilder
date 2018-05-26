package org.inferred.freebuilder.processor;

import static org.inferred.freebuilder.processor.BuildableType.PartialToBuilderMethod.TO_BUILDER_AND_MERGE;
import static org.inferred.freebuilder.processor.BuilderFactory.TypeInference.EXPLICIT_TYPES;
import static org.inferred.freebuilder.processor.BuilderMethods.addAllMethod;
import static org.inferred.freebuilder.processor.BuilderMethods.addMethod;
import static org.inferred.freebuilder.processor.Util.erasesToAnyOf;
import static org.inferred.freebuilder.processor.Util.upperBound;
import static org.inferred.freebuilder.processor.util.Block.methodBody;
import static org.inferred.freebuilder.processor.util.ModelUtils.maybeDeclared;
import static org.inferred.freebuilder.processor.util.feature.SourceLevel.diamondOperator;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

import org.inferred.freebuilder.processor.Metadata.Property;
import org.inferred.freebuilder.processor.util.Block;
import org.inferred.freebuilder.processor.util.Excerpt;
import org.inferred.freebuilder.processor.util.Excerpts;
import org.inferred.freebuilder.processor.util.SourceBuilder;
import org.inferred.freebuilder.processor.util.Variable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;

class BuildableListProperty extends PropertyCodeGenerator {

  static class Factory implements PropertyCodeGenerator.Factory {

    @Override
    public Optional<BuildableListProperty> create(Config config) {
      DeclaredType type = maybeDeclared(config.getProperty().getType()).orNull();
      if (type == null || !erasesToAnyOf(type, Collection.class, List.class, ImmutableList.class)) {
        return Optional.absent();
      }

      TypeMirror rawElementType = upperBound(config.getElements(), type.getTypeArguments().get(0));
      BuildableType element = BuildableType
          .create(rawElementType, config.getElements(), config.getTypes()).orNull();
      if (element == null) {
        return Optional.absent();
      }
      return Optional.of(new BuildableListProperty(
          config.getMetadata(),
          config.getProperty(),
          element));
    }
  }

  private final BuildableType element;

  private BuildableListProperty(Metadata metadata, Property property, BuildableType element) {
    super(metadata, property);
    this.element = element;
  }

  @Override
  public void addBuilderFieldDeclaration(SourceBuilder code) {
    code.addLine("private final %1$s<%2$s> %3$s = new %1$s%4$s();",
        ArrayList.class,
        element.builderType(),
        property.getField(),
        diamondOperator(element.builderType()));
  }

  @Override
  public void addBuilderFieldAccessors(SourceBuilder code) {
    addValueInstanceAdd(code);
    addBuilderAdd(code);
    addPreStreamsValueInstanceAddAll(code);
  }

  private void addValueInstanceAdd(SourceBuilder code) {
    code.addLine("")
        .addLine("public %s %s(%s element) {",
            metadata.getBuilder(), addMethod(property), element.type());
    Block body = methodBody(code, "element");
    if (element.partialToBuilder() == TO_BUILDER_AND_MERGE) {
      body.addLine("  %s.add(element.toBuilder());", property.getField());
    } else {
      body.addLine("  %s.add(%s.mergeFrom(element));",
          property.getField(),
          element.builderFactory().newBuilder(element.builderType(), EXPLICIT_TYPES));
    }
    body.addLine("  return (%s) this;", metadata.getBuilder());
    code.add(body)
        .addLine("}");
  }

  private void addBuilderAdd(SourceBuilder code) {
    code.addLine("")
        .addLine("public %s %s(%s builder) {",
            metadata.getBuilder(), addMethod(property), element.builderType())
        .add(methodBody(code, "builder")
          .addLine("  %s.add(%s.mergeFrom(builder));",
              property.getField(),
              element.builderFactory().newBuilder(element.builderType(), EXPLICIT_TYPES))
          .addLine("  return (%s) this;", metadata.getBuilder()))
        .addLine("}");
  }

  private void addPreStreamsValueInstanceAddAll(SourceBuilder code) {
    code.addLine("")
        .addLine("public %s %s(%s<? extends %s> elements) {",
            metadata.getBuilder(), addAllMethod(property), Iterable.class, element.type());
    Block body = methodBody(code, "elements");
    body.addLine("  if (elements instanceof %s) {", Collection.class);
    Variable size = new Variable("elementsSize");
    body.addLine("    int %s = ((%s<?>) elements).size();", size, Collection.class)
        .addLine("    %1$s.ensureCapacity(%1$s.size() + %2$s);", property.getField(), size)
        .addLine("  }")
        .add(Excerpts.forEach(element.type(), "elements", addMethod(property)))
        .addLine("  return (%s) this;", metadata.getBuilder());
    code.add(body)
        .addLine("}");
  }

  @Override
  public void addFinalFieldAssignment(Block code, Excerpt finalField, String builder) {
    Variable fieldBuilder = new Variable(property.getName() + "Builder");
    Variable fieldElement = new Variable("element");
    code.addLine("%s<%s> %s = %s.builder();",
            ImmutableList.Builder.class,
            element.type(),
            fieldBuilder,
            ImmutableList.class)
        .addLine("for (%s %s : %s) {",
            element.builderType(), fieldElement, property.getField().on(builder))
        .addLine("  %s.add(%s.build());", fieldBuilder, fieldElement)
        .addLine("}")
        .addLine("%s = %s.build();", finalField, fieldBuilder);
  }

  @Override
  public void addMergeFromValue(Block code, String value) {
    // TODO
  }

  @Override
  public void addMergeFromBuilder(Block code, String builder) {
    // TODO
  }

  @Override
  public void addSetFromResult(SourceBuilder code, Excerpt builder, Excerpt variable) {
    // TODO
  }

  @Override
  public void addClearField(Block code) {
    // TODO
  }
}
