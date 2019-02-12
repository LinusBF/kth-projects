defmodule MandelBrotPPM do
  def demo() do
    large(-2.6, 1.2, 1.2)
  end

  def small(x0, y0, xn) do
    width = 960
    height = 540
    depth = 64
    k = (xn - x0) / width
    image = Mandel.mandelbrot(width, height, x0, y0, k, depth)
    PPM.write("small.ppm", image)
  end

  def medium(x0, y0, xn) do
    width = 1650
    height = 720
    depth = 80
    k = (xn - x0) / width
    image = Mandel.mandelbrot(width, height, x0, y0, k, depth)
    PPM.write("medium.ppm", image)
  end

  def large(x0, y0, xn) do
    width = 1920
    height = 1080
    depth = 150
    k = (xn - x0) / width
    image = Mandel.mandelbrot(width, height, x0, y0, k, depth)
    PPM.write("large.ppm", image)
  end
end