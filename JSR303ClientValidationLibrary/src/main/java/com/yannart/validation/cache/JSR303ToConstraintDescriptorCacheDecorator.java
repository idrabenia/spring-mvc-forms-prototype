/**
 * Copyright (C) 2011 Yann Nicolas <yannart@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yannart.validation.cache;

import com.yannart.validation.JSR303ToConstraintDescriptor;

/**
 * Decorator of JSR303ToConstraintDescriptor adding caching support to avoid the
 * regeneration of constraint descriptors when it already have been done.
 * 
 * @author Yann Nicolas.
 */
public interface JSR303ToConstraintDescriptorCacheDecorator {

	/**
	 * {@inheritDoc} <br />
	 * 
	 * @param resetCache
	 *            defines if the cache must be reseted.
	 */
	public abstract String render(final Class<?> clazz, final boolean resetCache);

	/**
	 * {@inheritDoc} <br />
	 * 
	 * @param resetCache
	 *            defines if the cache must be reseted.
	 */
	public abstract String render(final Class<?> clazz,
			final boolean resetCache, final String... propertiesToIgnore);

	/**
	 * Obtains the wrapped object.
	 * 
	 * @return the wrappedJsr303ToConstraintDescriptor
	 */
	public abstract JSR303ToConstraintDescriptor getWrapped();

}