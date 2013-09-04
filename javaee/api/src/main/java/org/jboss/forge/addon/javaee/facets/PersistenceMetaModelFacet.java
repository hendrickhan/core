/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.forge.addon.javaee.facets;

import org.jboss.forge.addon.dependencies.Coordinate;
import org.jboss.forge.addon.javaee.JavaEEFacet;

/**
 * Returns information about metamodel generation for JPA projects
 * 
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 * 
 *         FIXME: Missing implementation
 */
public interface PersistenceMetaModelFacet extends JavaEEFacet
{
   /**
    * The annotation processor used
    */
   String getProcessor();

   /**
    * The compiler arguments used
    */
   String getCompilerArgs();

   /**
    * The Coordinate of the annotation processor
    */
   Coordinate getProcessorCoordinate();
}
