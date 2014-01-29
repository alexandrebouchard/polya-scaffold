package polya.mcmc;

import java.util.Collection;
import java.util.Random;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import tutorialj.Tutorial;



/**
 * A very simple MH move for real random variables, using a standard 
 * normal to propose.
 * 
 * @author Alexandre Bouchard (alexandre.bouchard@gmail.com)
 *
 */
public class RealVariableMHMove
  {
    final SummaryStatistics acceptanceProbabilities = new SummaryStatistics();
    private final RealVariable variable;
    private final Collection<? extends Factor> connectedFactors;
    
    public RealVariableMHMove(RealVariable variable,
        Collection<? extends Factor> connectedFactors)
    {
      this.variable = variable;
      this.connectedFactors = connectedFactors;
    }

    /**
     * #### Code to implement: RealVariableMHMove.sample
     * 
     * Before the resampling of these random variables work, you need to 
     * implement the core of the MH resampling move. Use a standard
     * normal proposal (``rand.nextGaussian()``).
     * 
     * See ``RealVariable`` and ``RealVariableMHMove.computeLogUnnormalizedPotentials()``.
     */
    @Tutorial(showSource = false, showLink = true, nextStep = MHTest.class)
    public void sample(Random rand)
    {
      throw new RuntimeException(); 
    }
    
    /**
     * Compute the part of the density that will be affected by 
     * chaning the variable held in this object.
     * 
     * @return
     */
    private double computeLogUnnormalizedPotentials()
    {
      double result = 0.0;
      for (Factor f : connectedFactors)
        result += f.logUnnormalizedPotential();
      return result;
    }
  }
