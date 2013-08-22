/**
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.ui.impl.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.forge.addon.ui.context.UIContext;
import org.jboss.forge.addon.ui.context.UIValidationContext;
import org.jboss.forge.addon.ui.input.InputComponent;

/**
 * 
 * @author <a href="ggastald@redhat.com">George Gastaldi</a>
 */
public class MockValidationContext implements UIValidationContext
{
   private UIContext context;
   private Map<InputComponent<?, ?>, List<String>> errors = new HashMap<InputComponent<?, ?>, List<String>>();

   public MockValidationContext(UIContext context)
   {
      this.context = context;
   }

   @Override
   public UIContext getUIContext()
   {
      return context;
   }

   @Override
   public void addValidationError(InputComponent<?, ?> input, String errorMessage)
   {
      List<String> list = errors.get(input);
      if (list == null)
      {
         list = new ArrayList<String>();
         errors.put(input, list);
      }
      list.add(errorMessage);
   }

   /**
    * @return the errors
    */
   public List<String> getErrorsFor(InputComponent<?, ?> input)
   {
      return errors.get(input);
   }
}
