defmodule Color do
  def convert(0, _max, steps) do
    getRGB(0, 0, steps)
  end
  def convert(depth, max, steps) do
    f = :math.log10(depth) / :math.log(max)
    a = f * steps
    x = Kernel.trunc(a)
    getRGB(x, a, steps)
  end

  def getRGB(0, a, steps) do
    y = Kernel.trunc(10 * (a / steps))
    y2 = Kernel.trunc(5 * (a / steps))
    {:rgb, 0 + y, 0, 0 + y2}
  end
  def getRGB(x, a, steps) do
    base = 255 - (5 * steps)
    y = Kernel.trunc(base * (a - x))
    high_red = Kernel.trunc(255 - (5 * (steps / x)))
    high_blue = Kernel.trunc(255 - (5 * (steps / x)))

    red = max(high_red - y, 0)
    green = 0
    blue = max(high_blue - y, 0)

    {:rgb, red, green, blue}
  end
end