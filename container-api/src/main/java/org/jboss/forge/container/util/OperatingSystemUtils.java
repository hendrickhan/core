/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.forge.container.util;

import java.io.File;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
public final class OperatingSystemUtils
{
   private static boolean PRETEND_WINDOWS = Boolean.getBoolean("forge.pretend_windows");

   private static String operatingSystem = null;

   public static String getOsName()
   {
      if (operatingSystem == null)
      {
         operatingSystem = System.getProperty("os.name");
      }
      return operatingSystem;
   }

   public static boolean isWindows()
   {
      return PRETEND_WINDOWS || getOsName().startsWith("Windows") || getOsName().startsWith("windows");
   }

   public static boolean isOSX()
   {
      return getOsName().startsWith("Mac") || getOsName().startsWith("mac");
   }

   public static boolean isLinux()
   {
      return getOsName().startsWith("Linux") || getOsName().startsWith("linux");
   }

   public static File getForgeHomeDir()
   {
      return new File(System.getProperty("forge.home")).getAbsoluteFile();
   }

   public static File getUserHomeDir()
   {
      return new File(System.getProperty("user.home")).getAbsoluteFile();
   }

   public static String getUserHomePath()
   {
      return getUserHomeDir().getAbsolutePath();
   }

   public static File getUserForgeDir()
   {
      return new File(getUserHomeDir(), ".forge").getAbsoluteFile();
   }

   public static void setPretendWindows(boolean value)
   {
      PRETEND_WINDOWS = value;
   }

   public static String getLineSeparator()
   {
      return System.getProperty("line.separator");
   }

   /**
    * The following characters are invalid as file or folder names on Windows using NTFS:
    *
    * / ? < > \ : * | ” and any character you can type with the Ctrl key
    *
    * @param filename
    * @return
    */
   public static String getSafeFilename(String filename)
   {
      String safeFilename;
      if (isWindows())
      {
         safeFilename = filename.replaceAll("[/?<>\\\\:*|\"]", "_");
      }
      else
      {
         safeFilename = filename;
      }
      return safeFilename;
   }
}
