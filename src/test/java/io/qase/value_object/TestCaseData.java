package io.qase.value_object;

import io.qase.page_object.TestRepositoryPage;

import java.util.List;

public class TestCaseData {
    private String title;
    private TestRepositoryPage.Status status;
    private String description;
    private TestRepositoryPage.Severity severity;
    private List<StepData> stepDataList;

    public TestCaseData(List<StepData> asList) {

    }


    public List<StepData> getStepDataList() {
        return stepDataList;
    }
    public void setStepDataList(List<StepData> stepDataList) {
        this.stepDataList = stepDataList;
    }



    public TestCaseData(String title,
                        TestRepositoryPage.Status status,
                        String description,
                        TestRepositoryPage.Severity severity,
                        List<StepData> stepDataList) {
        this.title = title;
        this.status = status;
        this.description = description;
        this.severity = severity;
        this.stepDataList = stepDataList;
    }



    public TestCaseData(String title,
                        TestRepositoryPage.Status status,
                        String description,
                        TestRepositoryPage.Severity severity) {
        this.title = title;
        this.status = status;
        this.description = description;
        this.severity = severity;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public TestRepositoryPage.Status getStatus() {
        return status;
    }
    public void setStatus(TestRepositoryPage.Status status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public TestRepositoryPage.Severity getSeverity() {
        return severity;
    }
    public void setSeverity(TestRepositoryPage.Severity severity) {
        this.severity = severity;
    }
}
