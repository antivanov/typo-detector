package fi.antivanov.typo.detector

import fi.antivanov.typo.detector.LevensteinDistance._
import org.scalatest._

class TypoDetectorSpec extends FreeSpec with Matchers {

  import TypoDetector.StringWithTypoDetection._

  "isTypoOf" - {
    "differs by two symbols => typo" in {
      "Helsinki".isTypoOf("Helsenke") shouldBe true
    }

    "differs by one symbol => typo" in {
      "Helsinki".isTypoOf("Helsenki") shouldBe true
    }

    "identical => not a typo" in {
      "Helsinki".isTypoOf("Helsinki") shouldBe false
    }

    "differs by three symbols => not a typo, too many different symbols" in {
      "Helsinki".isTypoOf("Helsingfors") shouldBe false
    }

    "allows to specify max number of different symbols" in {
      "Helsinki".isTypoOf("Helsingfors", maxMistypedSymbols = 5) shouldBe true
    }
  }
}
