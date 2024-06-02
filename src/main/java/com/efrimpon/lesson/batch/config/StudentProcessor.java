package com.efrimpon.lesson.batch.config;

import com.efrimpon.lesson.database.student.BatchStudent;
import org.springframework.batch.item.ItemProcessor;

public class StudentProcessor implements ItemProcessor<BatchStudent, BatchStudent> {

    /**
     * Process the provided item, returning a potentially modified or new item for
     * continued processing. If the returned result is {@code null}, it is assumed that
     * processing of the item should not continue.
     * <p>
     * A {@code null} item will never reach this method because the only possible sources
     * are:
     * <ul>
     * <li>an {@link ItemReader} (which indicates no more items)</li>
     * <li>a previous {@link ItemProcessor} in a composite processor (which indicates a
     * filtered item)</li>
     * </ul>
     *
     * @param item to be processed, never {@code null}.
     * @return potentially modified or new item for continued processing, {@code null} if
     * processing of the provided item should not continue.
     * @throws Exception thrown if exception occurs during processing.
     */
    @Override
    public BatchStudent process(BatchStudent item) throws Exception {
        //Business logic
        item.setId(null);
        return item;
    }
}
