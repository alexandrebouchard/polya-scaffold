package polya.parametric;

import polya.parametric.normal.CollapsedNIWModel;
import tutorialj.Tutorial;




/**
 * Utilities common to all conjugate models.
 * 
 * @author Alexandre Bouchard (alexandre.bouchard@gmail.com)
 */
public class Parametrics
{
  /**
   * ### Parametrics: Utilities common to all conjugate models.
   * 
   * #### Function to implement: logMarginal
   * 
   * You should fill in this function so that it computes p\_hp(data), 
   * marginalizing over parameters. See Equation (12,13) in
   * http://www.stat.ubc.ca/~bouchard/courses/stat547-sp2013-14/lecture/2014/01/12/notes-lecture3.html
   * 
   */
  @Tutorial(showSource = false, showLink = true)
  public static double logMarginal(
      CollapsedConjugateModel model,
      HyperParameter hp,
      SufficientStatistic data)
  {
    throw new RuntimeException();  
  }
  
  /**
   * #### Function to implement: logPredictive
   * 
   * You should fill in this function so that it computes p\_hp(newPoints|oldPoints).
   */
  @Tutorial(showSource = false, showLink = true, nextStep = CollapsedNIWModel.class)
  public static double logPredictive(
      CollapsedConjugateModel model,
      HyperParameter hp, 
      SufficientStatistic newPoints, 
      SufficientStatistic oldPoints)
  {
    throw new RuntimeException();  
  }

}
