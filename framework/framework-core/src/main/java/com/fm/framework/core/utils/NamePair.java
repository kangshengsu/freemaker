package com.fm.framework.core.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>NamePair</p>
 *
 * @author hubo
 */
@Data
public class NamePair implements Serializable {

    private Object name;

    private Object value;

    public boolean validate() {
        return Objects.nonNull(name) && Objects.nonNull(value);
    }

}
