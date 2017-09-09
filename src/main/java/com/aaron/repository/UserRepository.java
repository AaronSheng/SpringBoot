package com.aaron.repository;

import com.aaron.model.server.Tables;
import com.aaron.model.server.tables.User;
import com.aaron.model.server.tables.records.UserRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

/**
 * Created by Aaron Sheng on 2017/9/9.
 */
@Repository
public class UserRepository {

    public void set(DSLContext dslContext, UserRecord userRecord) {
        dslContext.update(Tables.USER)
                .set(Tables.USER.NAME, userRecord.getName())
                .where(Tables.USER.ID.eq(userRecord.getId()));
    }

    public UserRecord get(DSLContext dslContext, Long id) {
        return dslContext.selectFrom(Tables.USER)
                .where(Tables.USER.ID.eq(id))
                .fetchOne();
    }
}
