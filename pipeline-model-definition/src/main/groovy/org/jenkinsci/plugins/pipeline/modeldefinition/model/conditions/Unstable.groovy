/*
 * The MIT License
 *
 * Copyright (c) 2016, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.plugins.pipeline.modeldefinition.model.conditions

import hudson.Extension
import hudson.model.Result
import org.jenkinsci.Symbol
import org.jenkinsci.plugins.pipeline.modeldefinition.model.BuildCondition
import org.jenkinsci.plugins.workflow.job.WorkflowRun

import edu.umd.cs.findbugs.annotations.NonNull

/**
 * A {@link BuildCondition} for matching unstable builds.
 *
 * @author Andrew Bayer
 */
@Extension(ordinal=600d) @Symbol("unstable")
class Unstable extends BuildCondition {
    @Deprecated
    @Override
    boolean meetsCondition(@NonNull WorkflowRun r) {
        return meetsCondition(r, null, null)
    }

    @Override
    boolean meetsCondition(@NonNull WorkflowRun r, Object context, Throwable error) {
        return combineResults(r, error, context) == Result.UNSTABLE
    }

    @Override
    String getDescription() {
        return Messages.Unstable_Description()
    }

    static final long serialVersionUID = 1L
}
