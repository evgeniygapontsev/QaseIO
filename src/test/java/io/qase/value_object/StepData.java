package io.qase.value_object;

public class StepData {
    private String action;
    private String inputData;
    private String expectedResult;

    public StepData(String action, String inputData, String expectedResult) {
        this.action = action;
        this.inputData = inputData;
        this.expectedResult = expectedResult;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }
}
