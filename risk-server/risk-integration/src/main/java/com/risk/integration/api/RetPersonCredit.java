package com.risk.integration.api;

/**
 * Created by li on 2015/11/9.
 */
public class RetPersonCredit extends RetBase {

    private PersonCredit[] data;

    public PersonCredit[] getData() {
        return data;
    }

    public RetPersonCredit setData(PersonCredit[] data) {
        this.data = data;
        return this;
    }
}
