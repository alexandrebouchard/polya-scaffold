package polya.crp;

import java.util.List;
import java.util.Random;

import bayonet.distributions.Multinomial;

import polya.crp.utils.ClusterId;
import polya.parametric.CollapsedConjugateModel;
import polya.parametric.HyperParameter;
import polya.parametric.Parametrics;
import polya.parametric.SufficientStatistic;
import tutorialj.Tutorial;


/**
 * Samplers for CRPs.
 * 
 * @author Alexandre Bouchard (alexandre.bouchard@gmail.com)
 *
 */
public class CRPSamplers
{
  /**
   * ### Function to implement in this part
   * 
   * The main function to implement, ``CRPSamplers.gibbs()``,
   * should perform a single Gibbs step for the provided customer.
   * 
   * The probability of insertion at each table should combine 
   * the prior (via the provided ``PYPrior``) and the likelihood (via 
   * the provided 
   * ``CollapsedConjugateModel`` and ``HyperParameter``).
   * 
   * To make sure you are avoiding underflows, have a look 
   * at the utilities in ``bayonet.distributions.Multinomial``.
   */
  @Tutorial(showSource = false, showLink = true, nextStep = CRPMain.class)
  public static void gibbs(
      Random rand, 
      Integer customer,
      CRPState state, 
      HyperParameter hp, 
      CollapsedConjugateModel collapsedModel,
      PYPrior prior)
  {
    throw new RuntimeException();  
  }
}
