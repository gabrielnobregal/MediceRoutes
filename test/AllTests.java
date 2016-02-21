import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import br.com.bionexo.datastructures.BinaryHeapTest;
import br.com.bionexo.graph.algorithm.DistanceMeasureTest;
import br.com.bionexo.graph.algorithm.TripCounterTest;
import br.com.bionexo.graph.dijkstra.DijkstraTest;

@RunWith(Suite.class)
@SuiteClasses({ BinaryHeapTest.class, DistanceMeasureTest.class, TripCounterTest.class, DijkstraTest.class })
public class AllTests {

}
