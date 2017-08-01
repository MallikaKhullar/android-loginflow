package zolostays.zolo.Utils;

/**
 * Created by mallikapriyakhullar on 02/08/17.
 */

import java.lang.annotation.Documented;
        import java.lang.annotation.Retention;
        import java.lang.annotation.RetentionPolicy;

        import javax.inject.Qualifier;

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Local {

}
