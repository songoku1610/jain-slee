/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

/**
 * Start time:17:07:31 2009-01-31<br>
 * Project: mobicents-jainslee-server-core<br>
 * 
 * @author <a href="mailto:baranowb@gmail.com">baranowb - Bartosz Baranowski
 *         </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
package org.mobicents.slee.container.component.validator;

import java.util.List;

import org.mobicents.slee.container.component.SbbComponentImpl;
import org.mobicents.slee.container.component.deployment.jaxb.descriptors.SbbDescriptorFactoryImpl;
import org.mobicents.slee.container.component.deployment.jaxb.descriptors.SbbDescriptorImpl;
import org.mobicents.slee.container.component.deployment.jaxb.descriptors.TCUtilityClass;

/**
 * Start time:17:07:31 2009-01-31<br>
 * Project: mobicents-jainslee-server-core<br>
 * 
 * @author <a href="mailto:baranowb@gmail.com">baranowb - Bartosz Baranowski
 *         </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class SbbComponentValidatorSbbConstraintsACITest extends TCUtilityClass {

	public static final String _SBB_JAR_ONE_11_OK_CONSTRAINTS = "xml/validator/sbb/aci/sbb-jar-one-SbbConstraintsACIOk_1_1.xml";
	public static final String _SBB_JAR_ONE_11_OK_CONSTRAINTS_RETURN_BASE_TYPE = "xml/validator/sbb/aci/sbb-jar-one-SbbConstraintsACIReturnBaseOk_1_1.xml";
	public static final String _SBB_JAR_ONE_11_OK_CONSTRAINTS_WRONG_PARAMETER_TYPE = "xml/validator/sbb/aci/sbb-jar-one-SbbConstraintsACIWrongParameterType_1_1.xml";
	public static final String _SBB_JAR_ONE_11_OK_CONSTRAINTS_WRONG_METHOD = "xml/validator/sbb/aci/sbb-jar-one-SbbConstraintsACIWrongMethod_1_1.xml";

	public void testSbbOne11ConstraintsACIOk() throws Exception {

		List<SbbDescriptorImpl> specs = new SbbDescriptorFactoryImpl().parse(super.getFileStream(_SBB_JAR_ONE_11_OK_CONSTRAINTS));
		final SbbDescriptorImpl descriptor = specs.get(0);
		SbbComponentImpl component = new SbbComponentImpl(descriptor);
		component.setAbstractSbbClass(Thread.currentThread().getContextClassLoader().loadClass(
				descriptor.getSbbAbstractClass().getSbbAbstractClassName()));
		component.setActivityContextInterface(Thread.currentThread().getContextClassLoader().loadClass(
				descriptor.getSbbActivityContextInterface()));

		SbbComponentValidator validator = new SbbComponentValidator();
		validator.setComponent(component);

		boolean b = validator.validateSbbActivityContextInterface(ClassUtils.getAbstractMethodsFromClass(component.getAbstractSbbClass()), ClassUtils
				.getAbstractMethodsFromSuperClasses(component.getAbstractSbbClass()));

		assertTrue("Sbb class has not been validated", b);

	}

	public void testSbbOne11ConstraintsACIReturnBaseOk() throws Exception {

		List<SbbDescriptorImpl> specs = new SbbDescriptorFactoryImpl().parse(super.getFileStream(_SBB_JAR_ONE_11_OK_CONSTRAINTS_RETURN_BASE_TYPE));
		final SbbDescriptorImpl descriptor = specs.get(0);
		SbbComponentImpl component = new SbbComponentImpl(descriptor);
		component.setAbstractSbbClass(Thread.currentThread().getContextClassLoader().loadClass(
				descriptor.getSbbAbstractClass().getSbbAbstractClassName()));
		component.setActivityContextInterface(Thread.currentThread().getContextClassLoader().loadClass(
				descriptor.getSbbActivityContextInterface()));

		SbbComponentValidator validator = new SbbComponentValidator();
		validator.setComponent(component);

		boolean b = validator.validateSbbActivityContextInterface(ClassUtils.getAbstractMethodsFromClass(component.getAbstractSbbClass()), ClassUtils
				.getAbstractMethodsFromSuperClasses(component.getAbstractSbbClass()));

		assertTrue("Sbb class has not been validated", b);

	}

	public void testSbbOne11ConstraintsACIWrongMethod() throws Exception {

		List<SbbDescriptorImpl> specs = new SbbDescriptorFactoryImpl().parse(super.getFileStream(_SBB_JAR_ONE_11_OK_CONSTRAINTS_WRONG_METHOD));
		final SbbDescriptorImpl descriptor = specs.get(0);
		SbbComponentImpl component = new SbbComponentImpl(descriptor);
		component.setAbstractSbbClass(Thread.currentThread().getContextClassLoader().loadClass(
				descriptor.getSbbAbstractClass().getSbbAbstractClassName()));
		component.setActivityContextInterface(Thread.currentThread().getContextClassLoader().loadClass(
				descriptor.getSbbActivityContextInterface()));

		SbbComponentValidator validator = new SbbComponentValidator();
		validator.setComponent(component);

		boolean b = validator.validateSbbActivityContextInterface(ClassUtils.getAbstractMethodsFromClass(component.getAbstractSbbClass()), ClassUtils
				.getAbstractMethodsFromSuperClasses(component.getAbstractSbbClass()));

		assertFalse("Sbb class has been validated - it shoudl nto since only getter and setter methods are allowed", b);

	}

	public void testSbbOne11ConstraintsACIWrongParameterType() throws Exception {

		List<SbbDescriptorImpl> specs = new SbbDescriptorFactoryImpl().parse(super.getFileStream(_SBB_JAR_ONE_11_OK_CONSTRAINTS_WRONG_PARAMETER_TYPE));
		final SbbDescriptorImpl descriptor = specs.get(0);
		SbbComponentImpl component = new SbbComponentImpl(descriptor);
		component.setAbstractSbbClass(Thread.currentThread().getContextClassLoader().loadClass(
				descriptor.getSbbAbstractClass().getSbbAbstractClassName()));
		component.setActivityContextInterface(Thread.currentThread().getContextClassLoader().loadClass(
				descriptor.getSbbActivityContextInterface()));

		SbbComponentValidator validator = new SbbComponentValidator();
		validator.setComponent(component);

		boolean b = validator.validateSbbActivityContextInterface(ClassUtils.getAbstractMethodsFromClass(component.getAbstractSbbClass()), ClassUtils
				.getAbstractMethodsFromSuperClasses(component.getAbstractSbbClass()));

		assertFalse("Sbb class has been validated - it should not - Object is not permited type", b);

	}

}
