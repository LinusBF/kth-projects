defmodule Color do
  def convert(depth, max) do
    f = depth / max
    a = f * 10
    x = Kernel.trunc(a)
    y = Kernel.trunc(255 * (a - x))
    case x do
      0 -> {:rgb, y, 0, 0}
      1 -> {:rgb, 0, y, 0}
      2 -> {:rgb, 0, 0, y}
      3 -> {:rgb, 255, y, 0}
      4 -> {:rgb, 255, 0, y}
      5 -> {:rgb, y, 255, 0}
      6 -> {:rgb, 0, 255, y}
      7 -> {:rgb, y, 0, 255}
      8 -> {:rgb, 0, y, 255}
      9 -> {:rgb, 255 - y, 0, y}
      10 -> {:rgb, y, 0, 255 - y}
    end
  end
end