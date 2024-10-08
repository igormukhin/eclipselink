/*
 * Copyright (c) 1998, 2024 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     08/10/2009-2.0 Guy Pelletier
//       - 267391: JPA 2.0 implement/extend/use an APT tooling library for MetaModel API canonical classes
package org.eclipse.persistence.internal.jpa.modelgen.visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.AbstractAnnotationValueVisitor14;
import javax.lang.model.util.Elements;

import org.eclipse.persistence.internal.jpa.metadata.accessors.objects.MetadataAnnotation;

/**
 * An annotation element visitor.
 *
 * @author Guy Pelletier
 * @since EclipseLink 1.2
 */
public class AnnotationValueVisitor<R, P> extends AbstractAnnotationValueVisitor14<Object, Object> {

    private final Elements elementUtils;

    /**
     * INTERNAL:
     */
    public AnnotationValueVisitor(ProcessingEnvironment processingEnv) {
        elementUtils = processingEnv.getElementUtils();
    }

    /**
     * INTERNAL:
     * Visits an annotation mirror. Kicks off the building of the metadata
     * annotation.
     */
    @Override
    public Object visitAnnotation(AnnotationMirror annotationMirror, Object arg1) {
        // Set the name of the annotation.
        MetadataAnnotation annotation = new MetadataAnnotation();
        annotation.setName(annotationMirror.getAnnotationType().toString());

        // Process the values.
        for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : elementUtils.getElementValuesWithDefaults(annotationMirror).entrySet()) {
            String attribute = entry.getKey().getSimpleName().toString();
            AnnotationValue annotationValue = entry.getValue();
            Object attributeValue = annotationValue.accept(this, arg1);
            annotation.addAttribute(attribute, attributeValue);
        }

        return annotation;
    }

    /**
     * INTERNAL:
     *  e.g.
     *  joinColumns={
     *    &#064;JoinColumn(name="ID1", referencedColumnName="ID"),
     *    &#064;JoinColumn(name="ID2", referencedColumnName="ID")}
     */
    @Override
    public Object visitArray(List<? extends AnnotationValue> annotationValues, Object arg1) {
        ArrayList<Object> values = new ArrayList<>();

        for (AnnotationValue annotationValue : annotationValues) {
            values.add(annotationValue.accept(this, arg1));
        }

        return values.toArray();
    }

    /**
     * INTERNAL:
     * e.g. shared=true
     */
    @Override
    public Object visitBoolean(boolean bool, Object arg1) {
        return bool;
    }

    /**
     * INTERNAL:
     * e.g. byte=13
     */
    @Override
    public Object visitByte(byte b, Object arg1) {
        return b;
    }

    /**
     * INTERNAL:
     * e.g. type='c'
     */
    @Override
    public Object visitChar(char c, Object arg1) {
        return c;
    }

    /**
     * INTERNAL:
     * e.g. size=6.02E23
     */
    @Override
    public Object visitDouble(double d, Object arg1) {
        return d;
    }

    /**
     * INTERNAL:
     * e.g. fetch=LAZY
     */
    @Override
    public Object visitEnumConstant(VariableElement variableArgument, Object arg1) {
        return variableArgument.getSimpleName().toString();
    }

    /**
     * INTERNAL:
     * e.g. size=6.02e23f
     */
    @Override
    public Object visitFloat(float f, Object arg1) {
        return f;
    }

    /**
     * INTERNAL:
     * e.g. size=730
     */
    @Override
    public Object visitInt(int i, Object arg1) {
        return i;
    }

    /**
     * INTERNAL:
     * e.g. size=9223372036854775807
     */
    @Override
    public Object visitLong(long l, Object arg1) {
        return l;
    }

    /**
     * INTERNAL:
     * e.g. size=7
     */
    @Override
    public Object visitShort(short s, Object arg1) {
        return s;
    }

    /**
     * INTERNAL:
     * e.g. name="findAllSQLEmployees"
     */
    @Override
    public Object visitString(String str, Object arg1) {
        return str;
    }

    /**
     * INTERNAL:
     * e.g. targetEntity=Item.class
     */
    @Override
    public Object visitType(TypeMirror typeMirror, Object arg1) {
        return typeMirror.toString();
    }
}

