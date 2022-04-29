package validationTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ValidationOfToggleAllSelectAllListItems.class,ValidationOfRemovingOneListItem.class,ValidateForAllListItemsRemoval.class,ValidationOfCreatingListAndDeletingSame.class})

public class TestRunner {

}
