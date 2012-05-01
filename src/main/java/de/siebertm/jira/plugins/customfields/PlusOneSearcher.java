package de.siebertm.jira.plugins.customfields;

import com.atlassian.jira.issue.customfields.converters.DoubleConverter;
import com.atlassian.jira.issue.customfields.searchers.NumberRangeSearcher;
import com.atlassian.jira.issue.customfields.searchers.transformer.CustomFieldInputHelper;
import com.atlassian.jira.jql.operand.JqlOperandResolver;

/**
 * Created with IntelliJ IDEA.
 * User: micha
 * Date: 5/1/12
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlusOneSearcher extends NumberRangeSearcher {

    public PlusOneSearcher(JqlOperandResolver jqlOperandResolver, DoubleConverter doubleConverter, CustomFieldInputHelper customFieldInputHelper) {
        super(jqlOperandResolver, doubleConverter, customFieldInputHelper);
    }

}
