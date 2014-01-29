package polya.parametric.normal;



import java.util.Random;

import org.apache.commons.lang3.tuple.Pair;
import org.ejml.simple.SimpleMatrix;

import polya.parametric.CollapsedConjugateModel;
import polya.parametric.HyperParameter;
import polya.parametric.Parameter;
import polya.parametric.SufficientStatistic;
import polya.parametric.TestedModel;
import tutorialj.Tutorial;
import bayonet.distributions.Normal;
import bayonet.math.EJMLUtils;
import bayonet.math.SpecialFunctions;


/**
 * 
 * @author Alexandre Bouchard (alexandre.bouchard@gmail.com)
 *
 */
public class CollapsedNIWModel implements CollapsedConjugateModel, TestedModel
{
  public static CollapsedNIWModel instance = new CollapsedNIWModel();
  private CollapsedNIWModel() {}

  /**
   * ### CollapsedNIWModel: Implementation of a NIW model
   * 
   * Make sure you check this source carefully: p.46 of 
   * 
   * http://cs.brown.edu/~sudderth/papers/sudderthPhD.pdf
   * 
   * Also, for matrix computation you will be using EJML:
   * 
   * https://code.google.com/p/efficient-java-matrix-library/wiki/SimpleMatrix
   * 
   * I suggest to start with ``SimpleMatrix`` operations (but see optional
   * questions for suggested optional improvements in this 
   * area).
   * 
   * #### Method to implement: logPriorDensityAtThetaStar
   * 
   * See 
   * ``CollapsedConjugateModel``, ``NIWHyperParameter``, as well
   * as ``bayonet.SpecialFunctions.multivariateLogGamma()``.
   * 
   */
  @Tutorial(showSource = false, showLink = true)
  @Override
  public double logPriorDensityAtThetaStar(HyperParameter _hp)
  {
    NIWHyperParameter hp = (NIWHyperParameter) _hp;
    
    throw new RuntimeException(); 
  }

  /**
   * #### Method to implement: logLikelihoodGivenThetaStar
   * 
   * See 
   * ``CollapsedConjugateModel``, ``SufficientStatistic``, as well as
   * ``bayonet.distributions.Normal``.
   * 
   * Hint: pick theta* to have mean zero and identity covariance.
   * 
   */
  @Tutorial(showSource = false, showLink = true)
  @Override
  public double logLikelihoodGivenThetaStar(SufficientStatistic _data)
  {
    TwoMomentsSufficientStatistics data = (TwoMomentsSufficientStatistics) _data;

    throw new RuntimeException(); 
  }
  
  /**
   * #### Method to implement: update
   * 
   * This is the last one
   * before the end of the parametric part of this exercise!
   * 
   * See 
   * ``CollapsedConjugateModel``, ``NIWHyperParameter``, ``SufficientStatistic``.
   */
  @Tutorial(showSource = false, showLink = true)
  @Override
  public HyperParameter update(HyperParameter _before, SufficientStatistic _data)
  {
    NIWHyperParameter before = (NIWHyperParameter) _before;
    TwoMomentsSufficientStatistics data = (TwoMomentsSufficientStatistics) _data;
    
    checkCompatible(before, data);
    
    throw new RuntimeException(); 
  }

  /**
   * Performs a simple sanity check on dimensionality.
   * @param before
   * @param data
   */
  private void checkCompatible(NIWHyperParameter before,
      TwoMomentsSufficientStatistics data)
  {
    if (before.dim() != data.dim())
      throw new RuntimeException();
  }

  /**
   * Used for testing purpose. See ParametricsTutorial and TestedModel.
   */
  @SuppressWarnings({"unchecked","rawtypes"})
  @Override
  public Pair<Parameter, SufficientStatistic> generateData(
      Random rand,
      HyperParameter _hp, 
      int nDataPoints)
  {
    NIWHyperParameter hp = (NIWHyperParameter) _hp;
    // generate prior
    MVNParameter parameter = NIWs.nextNIW(rand, hp);
    // generate data
    TwoMomentsSufficientStatistics stats = TwoMomentsSufficientStatistics.fromEmpty(hp.dim());
    for (int i = 0; i < nDataPoints; i++)
    {
      SimpleMatrix sample = NIWs.nextMVN(rand, parameter.getMeanParameter(), parameter.getCovarianceParameter());
      stats.plusEqual(TwoMomentsSufficientStatistics.fromOnePoint(sample.getMatrix().getData()));
    }
    Pair result = Pair.of(parameter, stats);
    return result;
  }

  /**
   * Used for testing purpose. See ParametricsTutorial and TestedModel
   */
  @Override
  public Parameter maximumAPosteriori(HyperParameter _hp)
  {
    NIWHyperParameter hp = (NIWHyperParameter) _hp;
    return NIWs.maximumAPosteriori(hp);
  }

  /**
   * Used for testing purpose. See ParametricsTutorial and TestedModel
   */
  @Override
  public double distance(Parameter _truth, Parameter _reconstructed)
  {
    MVNParameter truth = (MVNParameter) _truth;
    MVNParameter reconstructed = (MVNParameter) _reconstructed;
    double norm = NIWs.lInfinityDistance(truth, reconstructed);
    return norm;
  }
}
