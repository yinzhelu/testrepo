import unittest
import Experiment

class MyTestCase(unittest.TestCase):

  def test_t1(self):
    r1 = Experiment.largest([3,4,5]) 
    self.assertEqual(r1, 5)

  def test_t2(self):
    self.assertRaises(ValueError, Experiment.largest, [1.2, 1.1, 1.3])

if __name__ == '__main__':
  unittest.main()
