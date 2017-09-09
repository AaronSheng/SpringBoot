package com.aaron.repository;

import com.aaron.model.community.Tables;
import com.aaron.model.community.tables.records.UserRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

/**
 * Created by Aaron Sheng on 2017/9/9.
 */
@Repository
public class CommunityUserRepository {

    public void set(DSLContext dslContext, UserRecord userRecord) {
        dslContext.insertInto(Tables.USER, Tables.USER.ID, Tables.USER.NAME)
                .values(userRecord.getId(), userRecord.getName())
                .execute();
    }

    public UserRecord get(DSLContext dslContext, Long id) {
        return dslContext.selectFrom(Tables.USER)
                .where(Tables.USER.ID.eq(id))
                .fetchOne();
    }
}
