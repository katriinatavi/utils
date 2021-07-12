package org.songtang.enums;

/**
 * 响应类型
 * @author: song
 * @Description:
 * @Date: Created in 14:23 2018/6/6
 * @Modified By:
 */
public enum ResultTypeEnum {
    SUCCESS {
        public int getCode() {
            return 0;
        }

        public String getMessage() {
            return "操作成功";
        }
    },
    FAIL {
        public int getCode() {
            return 1;
        }
    },
    OTHER {
        public int getCode() {
            return 2;
        }
    };

    public abstract int getCode();

    public String getMessage() {
        return "";
    }
}
