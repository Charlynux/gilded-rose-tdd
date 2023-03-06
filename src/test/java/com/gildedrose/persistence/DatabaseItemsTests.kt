package com.gildedrose.persistence

import org.jetbrains.exposed.sql.SchemaUtils.createMissingTablesAndColumns
import org.jetbrains.exposed.sql.SchemaUtils.drop
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestDatabaseExtension::class)
class DatabaseItemsTests : ItemsContract(DatabaseItems(testDatabase))
{
    @BeforeEach
    fun resetDB() {
        transaction(testDatabase) {
            drop(DatabaseItems.ItemsTable)
            createMissingTablesAndColumns(DatabaseItems.ItemsTable)
        }
    }
}
