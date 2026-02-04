package domain.service;

import application.port.OutputPort;
import domain.model.Result;
import domain.model.ResultValues;
import domain.model.WordCondition;

public class Game {

    private final Result result;
    private final OutputPort outputPort;
    private boolean isFinished;

    public Game(Result result, OutputPort outputPort) {
        this.result = result;
        this.outputPort = outputPort;
    }

    public void updateFinished() {
        if (ResultValues.correct().equals(result.getBoard())) {
            this.isFinished = true;
        }
        if (WordCondition.입력_제한_횟수.getValue() == result.getCurrentTryCount()) {
            this.isFinished = false;
        }
    }

    public boolean checkedTryCount() {
        if (WordCondition.입력_제한_횟수.getValue() < result.getCurrentTryCount()) {
            System.out.println(this.outputPort.getTryCountExceededMessage());
            return false;
        }
        return true;
    }

    public boolean isFinished() {
        return this.isFinished;
    }
}
