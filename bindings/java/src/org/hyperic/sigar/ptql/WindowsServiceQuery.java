/*
 * Copyright (C) [2004, 2005, 2006], Hyperic, Inc.
 * This file is part of SIGAR.
 * 
 * SIGAR is free software; you can redistribute it and/or modify
 * it under the terms version 2 of the GNU General Public License as
 * published by the Free Software Foundation. This program is distributed
 * in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA.
 */

package org.hyperic.sigar.ptql;

import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarProxy;
import org.hyperic.sigar.SigarException;

public class WindowsServiceQuery implements ProcessQuery {

    private String name;

    public WindowsServiceQuery(String name) {
        this.name = name;
    }

    public boolean match(SigarProxy sigar, long pid) 
        throws SigarException {

        return pid == sigar.getServicePid(this.name);
    }

    public static void main(String[] args) throws Exception {
        Sigar sigar = new Sigar(); //load the .dll
        System.out.println(sigar.getServicePid(args[0]));
    }
}