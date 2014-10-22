import unittest
import Experiment

class MyTestCase(unittest.TestCase):

  def test_t1(self):
    r1 = Experiment.largest([3,4,5]) 
    self.assertEqual(r1, 5)

if __name__ == '__main__':
  unittest.main()
