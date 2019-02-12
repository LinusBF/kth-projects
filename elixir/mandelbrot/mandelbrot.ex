defmodule MandelBrotPPM do
  def demo() do
    large(0.01, -0.47, 0.4, 300)
  end

  def small(x0, y0, n, d) do
    width = 960
    height = 540
    depth = d
    k = n / width
    image = Mandel.mandelbrot(width, height, x0, y0, k, depth)
    PPM.write("small.ppm", image)
  end

  def medium(x0, y0, n, d) do
    width = 1650
    height = 720
    depth = d
    k = n / width
    image = Mandel.mandelbrot(width, height, x0, y0, k, depth)
    PPM.write("medium.ppm", image)
  end

  def large(x0, y0, n, d) do
    width = 1920
    height = 1080
    depth = d
    k = n / width
    image = Mandel.mandelbrot(width, height, x0, y0, k, depth)
    PPM.write("large.ppm", image)
  end

  def large2(x0, y0, n, d) do
    width = 1920
    height = 1080
    depth = d
    k = n / width
    image = Mandel.mandelbrot(width, height, x0, y0, k, depth)
    PPM.write("large2.ppm", image)
  end

  def huge(x0, y0, n, d) do
    width = 3840
    height = 2160
    depth = d
    k = n / width
    image = Mandel.mandelbrot(width, height, x0, y0, k, depth)
    PPM.write("huge.ppm", image)
  end
end