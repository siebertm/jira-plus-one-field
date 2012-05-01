package de.siebertm.jira.plugins.customfields;

import com.atlassian.jira.issue.comments.Comment;
import com.atlassian.jira.issue.comments.CommentManager;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.jira.user.util.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.issue.customfields.impl.CalculatedCFType;
import com.atlassian.jira.issue.customfields.impl.FieldValidationException;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.fields.config.FieldConfig;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutItem;

import java.util.Map;

public class PlusOneField extends CalculatedCFType {
    private static final Logger log = LoggerFactory.getLogger(PlusOneField.class);

    private JiraAuthenticationContext authenticationContext = null;
    private CommentManager commentManager = null;
    private UserManager userManager = null;

    /**
     * Picocontainer should populate this
     * @see "http://confluence.atlassian.com/display/JIRA/PicoContainer+and+JIRA" />
     * @param authenticationContext authentication Context
     * @param commentManager comment Manager
     * @param userManager user manager
     */
    public PlusOneField(JiraAuthenticationContext authenticationContext, CommentManager commentManager, UserManager userManager) {
        this.authenticationContext = authenticationContext;
        this.commentManager = commentManager;
        this.userManager = userManager;
    }

    @java.lang.Override
    public String getStringFromSingularObject(java.lang.Object object) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @java.lang.Override
    public Object getSingularObjectFromString(java.lang.String string) throws FieldValidationException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @java.lang.Override
    public Object getValueFromIssue(CustomField customField, Issue issue) {
        double plusOnes = 0;

        for(Comment c : commentManager.getComments(issue)) {
            String body = c.getBody();

            if(body.contains("+1")) {
                plusOnes++;
            }
        }

        return plusOnes;
    }


    @Override
    public Map<String, Object> getVelocityParameters(final Issue issue,
                                                     final CustomField field,
                                                     final FieldLayoutItem fieldLayoutItem) {
        final Map<String, Object> map = super.getVelocityParameters(issue, field, fieldLayoutItem);

        // This method is also called to get the default value, in
        // which case issue is null so we can't use it to add currencyLocale
        if (issue == null) {
            return map;
        }

        FieldConfig fieldConfig = field.getRelevantConfig(issue);
        //add what you need to the map here

        return map;
    }
}