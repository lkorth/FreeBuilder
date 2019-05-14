/*
 * Copyright 2015 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.inferred.freebuilder.processor.property;

import static org.inferred.freebuilder.processor.GeneratedTypeSubject.assertThat;
import static org.inferred.freebuilder.processor.model.ClassTypeImpl.INTEGER;
import static org.inferred.freebuilder.processor.model.ClassTypeImpl.STRING;
import static org.inferred.freebuilder.processor.model.GenericTypeElementImpl.newTopLevelGenericType;
import static org.inferred.freebuilder.processor.model.PrimitiveTypeImpl.INT;
import static org.inferred.freebuilder.processor.source.FunctionalType.unaryOperator;

import com.google.common.collect.ImmutableMap;

import org.inferred.freebuilder.processor.BuilderFactory;
import org.inferred.freebuilder.processor.Datatype;
import org.inferred.freebuilder.processor.GeneratedBuilder;
import org.inferred.freebuilder.processor.model.GenericTypeElementImpl;
import org.inferred.freebuilder.processor.model.GenericTypeElementImpl.GenericTypeMirrorImpl;
import org.inferred.freebuilder.processor.property.OptionalProperty.OptionalType;
import org.inferred.freebuilder.processor.source.QualifiedName;
import org.inferred.freebuilder.processor.source.feature.GuavaLibrary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Optional;

@RunWith(JUnit4.class)
public class GuavaOptionalSourceTest {

  @Test
  public void testSource() {
    assertThat(builder()).given(GuavaLibrary.AVAILABLE).generates(
        "// Autogenerated code. Do not modify.",
        "package com.example;",
        "",
        "import com.example.Person;",
        "import com.google.common.annotations.VisibleForTesting;",
        "import com.google.common.base.Optional;",
        "import java.util.Objects;",
        "import java.util.function.UnaryOperator;",
        "",
        "/** Auto-generated superclass of {@link Person.Builder}, "
            + "derived from the API of {@link Person}. */",
        "abstract class Person_Builder {",
        "",
        "  /**",
        "   * Creates a new builder using {@code value} as a template.",
        "   *",
        "   * <p>If {@code value} is a partial, the builder will return more partials.",
        "   */",
        "  public static Person.Builder from(Person value) {",
        "    if (value instanceof Rebuildable) {",
        "      return ((Rebuildable) value).toBuilder();",
        "    } else {",
        "      return new Person.Builder().mergeFrom(value);",
        "    }",
        "  }",
        "",
        "  // Store a nullable object instead of an Optional. Escape analysis then",
        "  // allows the JVM to optimize away the Optional objects created by and",
        "  // passed to our API.",
        "  private String name = null;",
        "  // Store a nullable object instead of an Optional. Escape analysis then",
        "  // allows the JVM to optimize away the Optional objects created by and",
        "  // passed to our API.",
        "  private Integer age = null;",
        "",
        "  /**",
        "   * Sets the value to be returned by {@link Person#name()}.",
        "   *",
        "   * @return this {@code Builder} object",
        "   * @throws NullPointerException if {@code name} is null",
        "   */",
        "  public Person.Builder name(String name) {",
        "    this.name = Objects.requireNonNull(name);",
        "    return (Person.Builder) this;",
        "  }",
        "",
        "  /**",
        "   * Sets the value to be returned by {@link Person#name()}.",
        "   *",
        "   * @return this {@code Builder} object",
        "   */",
        "  public Person.Builder name(Optional<? extends String> name) {",
        "    if (name.isPresent()) {",
        "      return name(name.get());",
        "    } else {",
        "      return clearName();",
        "    }",
        "  }",
        "",
        "  /**",
        "   * Sets the value to be returned by {@link Person#name()}.",
        "   *",
        "   * @return this {@code Builder} object",
        "   */",
        "  public Person.Builder nullableName(String name) {",
        "    if (name != null) {",
        "      return name(name);",
        "    } else {",
        "      return clearName();",
        "    }",
        "  }",
        "",
        "  /**",
        "   * If the value to be returned by {@link Person#name()} is present, replaces it by "
            + "applying {@code",
        "   * mapper} to it and using the result.",
        "   *",
        "   * <p>If the result is null, clears the value.",
        "   *",
        "   * @return this {@code Builder} object",
        "   * @throws NullPointerException if {@code mapper} is null",
        "   */",
        "  public Person.Builder mapName(UnaryOperator<String> mapper) {",
        "    Objects.requireNonNull(mapper);",
        "    Optional<String> oldName = name();",
        "    if (oldName.isPresent()) {",
        "      nullableName(mapper.apply(oldName.get()));",
        "    }",
        "    return (Person.Builder) this;",
        "  }",
        "",
        "  /**",
        "   * Sets the value to be returned by {@link Person#name()} to {@link Optional#absent()",
        "   * Optional.absent()}.",
        "   *",
        "   * @return this {@code Builder} object",
        "   */",
        "  public Person.Builder clearName() {",
        "    name = null;",
        "    return (Person.Builder) this;",
        "  }",
        "",
        "  /** Returns the value that will be returned by {@link Person#name()}. */",
        "  public Optional<String> name() {",
        "    return Optional.fromNullable(name);",
        "  }",
        "",
        "  /**",
        "   * Sets the value to be returned by {@link Person#age()}.",
        "   *",
        "   * @return this {@code Builder} object",
        "   */",
        "  public Person.Builder age(int age) {",
        "    this.age = age;",
        "    return (Person.Builder) this;",
        "  }",
        "",
        "  /**",
        "   * Sets the value to be returned by {@link Person#age()}.",
        "   *",
        "   * @return this {@code Builder} object",
        "   */",
        "  public Person.Builder age(Optional<? extends Integer> age) {",
        "    if (age.isPresent()) {",
        "      return age(age.get());",
        "    } else {",
        "      return clearAge();",
        "    }",
        "  }",
        "",
        "  /**",
        "   * Sets the value to be returned by {@link Person#age()}.",
        "   *",
        "   * @return this {@code Builder} object",
        "   */",
        "  public Person.Builder nullableAge(Integer age) {",
        "    if (age != null) {",
        "      return age(age);",
        "    } else {",
        "      return clearAge();",
        "    }",
        "  }",
        "",
        "  /**",
        "   * If the value to be returned by {@link Person#age()} is present, replaces it by "
            + "applying {@code",
        "   * mapper} to it and using the result.",
        "   *",
        "   * <p>If the result is null, clears the value.",
        "   *",
        "   * @return this {@code Builder} object",
        "   * @throws NullPointerException if {@code mapper} is null",
        "   */",
        "  public Person.Builder mapAge(UnaryOperator<Integer> mapper) {",
        "    Objects.requireNonNull(mapper);",
        "    Optional<Integer> oldAge = age();",
        "    if (oldAge.isPresent()) {",
        "      nullableAge(mapper.apply(oldAge.get()));",
        "    }",
        "    return (Person.Builder) this;",
        "  }",
        "",
        "  /**",
        "   * Sets the value to be returned by {@link Person#age()} to {@link Optional#absent()",
        "   * Optional.absent()}.",
        "   *",
        "   * @return this {@code Builder} object",
        "   */",
        "  public Person.Builder clearAge() {",
        "    age = null;",
        "    return (Person.Builder) this;",
        "  }",
        "",
        "  /** Returns the value that will be returned by {@link Person#age()}. */",
        "  public Optional<Integer> age() {",
        "    return Optional.fromNullable(age);",
        "  }",
        "",
        "  /**",
        "   * Copies values from {@code value}, skipping empty optionals.",
        "   *",
        "   * @return this {@code Builder} object",
        "   */",
        "  public Person.Builder mergeFrom(Person value) {",
        "    if (value.name().isPresent()) {",
        "      name(value.name().get());",
        "    }",
        "    if (value.age().isPresent()) {",
        "      age(value.age().get());",
        "    }",
        "    return (Person.Builder) this;",
        "  }",
        "",
        "  /**",
        "   * Copies values from {@code template}, skipping empty optionals.",
        "   *",
        "   * @return this {@code Builder} object",
        "   */",
        "  public Person.Builder mergeFrom(Person.Builder template) {",
        "    if (template.name().isPresent()) {",
        "      name(template.name().get());",
        "    }",
        "    if (template.age().isPresent()) {",
        "      age(template.age().get());",
        "    }",
        "    return (Person.Builder) this;",
        "  }",
        "",
        "  /**",
        "   * Resets the state of this builder.",
        "   *",
        "   * @return this {@code Builder} object",
        "   */",
        "  public Person.Builder clear() {",
        "    Person_Builder defaults = new Person.Builder();",
        "    name = defaults.name;",
        "    age = defaults.age;",
        "    return (Person.Builder) this;",
        "  }",
        "",
        "  /** Returns a newly-created {@link Person} based on the contents of this "
            + "{@code Builder}. */",
        "  public Person build() {",
        "    return new Value(this);",
        "  }",
        "",
        "  /**",
        "   * Returns a newly-created partial {@link Person} for use in unit tests. "
            + "State checking will not",
        "   * be performed.",
        "   *",
        "   * <p>The builder returned by {@link Person.Builder#from(Person)} will propagate the "
            + "partial",
        "   * status of its input, overriding {@link Person.Builder#build() build()} to return "
            + "another",
        "   * partial. This allows for robust tests of modify-rebuild code.",
        "   *",
        "   * <p>Partials should only ever be used in tests. "
            + "They permit writing robust test cases that won't",
        "   * fail if this type gains more application-level constraints "
            + "(e.g. new required fields) in",
        "   * future. If you require partially complete values in production code, "
            + "consider using a Builder.",
        "   */",
        "  @VisibleForTesting()",
        "  public Person buildPartial() {",
        "    return new Partial(this);",
        "  }",
        "",
        "  private abstract static class Rebuildable extends Person {",
        "    public abstract Person.Builder toBuilder();",
        "  }",
        "",
        "  private static final class Value extends Rebuildable {",
        "    // Store a nullable object instead of an Optional. Escape analysis then",
        "    // allows the JVM to optimize away the Optional objects created by our",
        "    // getter method.",
        "    private final String name;",
        "    // Store a nullable object instead of an Optional. Escape analysis then",
        "    // allows the JVM to optimize away the Optional objects created by our",
        "    // getter method.",
        "    private final Integer age;",
        "",
        "    private Value(Person_Builder builder) {",
        "      this.name = builder.name;",
        "      this.age = builder.age;",
        "    }",
        "",
        "    @Override",
        "    public Optional<String> name() {",
        "      return Optional.fromNullable(name);",
        "    }",
        "",
        "    @Override",
        "    public Optional<Integer> age() {",
        "      return Optional.fromNullable(age);",
        "    }",
        "",
        "    @Override",
        "    public Person.Builder toBuilder() {",
        "      Person_Builder builder = new Person.Builder();",
        "      builder.name = name;",
        "      builder.age = age;",
        "      return (Person.Builder) builder;",
        "    }",
        "",
        "    @Override",
        "    public boolean equals(Object obj) {",
        "      if (!(obj instanceof Value)) {",
        "        return false;",
        "      }",
        "      Value other = (Value) obj;",
        "      return Objects.equals(name, other.name) && Objects.equals(age, other.age);",
        "    }",
        "",
        "    @Override",
        "    public int hashCode() {",
        "      return Objects.hash(name, age);",
        "    }",
        "",
        "    @Override",
        "    public String toString() {",
        "      StringBuilder result = new StringBuilder(\"Person{\");",
        "      String separator = \"\";",
        "      if (name != null) {",
        "        result.append(\"name=\").append(name);",
        "        separator = \", \";",
        "      }",
        "      if (age != null) {",
        "        result.append(separator).append(\"age=\").append(age);",
        "      }",
        "      return result.append(\"}\").toString();",
        "    }",
        "  }",
        "",
        "  private static final class Partial extends Rebuildable {",
        "    // Store a nullable object instead of an Optional. Escape analysis then",
        "    // allows the JVM to optimize away the Optional objects created by our",
        "    // getter method.",
        "    private final String name;",
        "    // Store a nullable object instead of an Optional. Escape analysis then",
        "    // allows the JVM to optimize away the Optional objects created by our",
        "    // getter method.",
        "    private final Integer age;",
        "",
        "    Partial(Person_Builder builder) {",
        "      this.name = builder.name;",
        "      this.age = builder.age;",
        "    }",
        "",
        "    @Override",
        "    public Optional<String> name() {",
        "      return Optional.fromNullable(name);",
        "    }",
        "",
        "    @Override",
        "    public Optional<Integer> age() {",
        "      return Optional.fromNullable(age);",
        "    }",
        "",
        "    private static class PartialBuilder extends Person.Builder {",
        "      @Override",
        "      public Person build() {",
        "        return buildPartial();",
        "      }",
        "    }",
        "",
        "    @Override",
        "    public Person.Builder toBuilder() {",
        "      Person_Builder builder = new PartialBuilder();",
        "      builder.name = name;",
        "      builder.age = age;",
        "      return (Person.Builder) builder;",
        "    }",
        "",
        "    @Override",
        "    public boolean equals(Object obj) {",
        "      if (!(obj instanceof Partial)) {",
        "        return false;",
        "      }",
        "      Partial other = (Partial) obj;",
        "      return Objects.equals(name, other.name) && Objects.equals(age, other.age);",
        "    }",
        "",
        "    @Override",
        "    public int hashCode() {",
        "      return Objects.hash(name, age);",
        "    }",
        "",
        "    @Override",
        "    public String toString() {",
        "      StringBuilder result = new StringBuilder(\"partial Person{\");",
        "      String separator = \"\";",
        "      if (name != null) {",
        "        result.append(\"name=\").append(name);",
        "        separator = \", \";",
        "      }",
        "      if (age != null) {",
        "        result.append(separator).append(\"age=\").append(age);",
        "      }",
        "      return result.append(\"}\").toString();",
        "    }",
        "  }",
        "}");
  }

  private static GeneratedBuilder builder() {
    GenericTypeElementImpl optional = newTopLevelGenericType("com.google.common.base.Optional");
    GenericTypeMirrorImpl optionalInteger = optional.newMirror(INTEGER);
    GenericTypeMirrorImpl optionalString = optional.newMirror(STRING);
    QualifiedName person = QualifiedName.of("com.example", "Person");
    QualifiedName generatedBuilder = QualifiedName.of("com.example", "Person_Builder");

    Datatype datatype = new Datatype.Builder()
        .setBuilder(person.nestedType("Builder").withParameters())
        .setExtensible(true)
        .setBuilderFactory(BuilderFactory.NO_ARGS_CONSTRUCTOR)
        .setBuilderSerializable(false)
        .setGeneratedBuilder(generatedBuilder.withParameters())
        .setInterfaceType(false)
        .setPartialType(generatedBuilder.nestedType("Partial").withParameters())
        .setPropertyEnum(generatedBuilder.nestedType("Property").withParameters())
        .setRebuildableType(generatedBuilder.nestedType("Rebuildable").withParameters())
        .setType(person.withParameters())
        .setValueType(generatedBuilder.nestedType("Value").withParameters())
        .build();
    Property name = new Property.Builder()
        .setAllCapsName("NAME")
        .setBoxedType(optionalString)
        .setCapitalizedName("Name")
        .setFullyCheckedCast(true)
        .setGetterName("name")
        .setName("name")
        .setType(optionalString)
        .setUsingBeanConvention(false)
        .setInEqualsAndHashCode(true)
        .setInToString(true)
        .build();
    Property age = new Property.Builder()
        .setAllCapsName("AGE")
        .setBoxedType(optionalInteger)
        .setCapitalizedName("Age")
        .setFullyCheckedCast(true)
        .setGetterName("age")
        .setName("age")
        .setType(optionalInteger)
        .setUsingBeanConvention(false)
        .setInEqualsAndHashCode(true)
        .setInToString(true)
        .build();

    return new GeneratedBuilder(datatype, ImmutableMap.of(
        name, new OptionalProperty(
            datatype,
            name,
            OptionalType.GUAVA,
            STRING,
            Optional.empty(),
            unaryOperator(STRING)),
        age, new OptionalProperty(
            datatype,
            age,
            OptionalType.GUAVA,
            INTEGER,
            Optional.of(INT),
            unaryOperator(INTEGER))));
  }
}
