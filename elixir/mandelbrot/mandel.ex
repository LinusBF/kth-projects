defmodule Mandel do
  def mandelbrot(width, height, x, y, k, depth) do
    trans = fn(w, h) ->
      Cmplx.new(x + k * (w - 1), y - k * (h - 1))
    end
    rows(width, height, trans, depth, [])
  end

  def rows(w, h, trans, depth, []) do
    [row(w, h, trans, depth) | rows(w, h - 1, trans, depth)]
  end
  def rows(_w, 0, _trans, _depth) do
    []
  end
  def rows(w, h, trans, depth) do
    [row(w, h, trans, depth) | rows(w, h - 1, trans, depth)]
  end

  def row(0, _h, _trans, _depth) do [] end
  def row(w, h, trans, depth) do [pixel(w, h, trans, depth) | row(w - 1, h, trans, depth)] end

  def pixel(w, h, trans, d) do
    zDepth = Brot.mandelbrot(trans.(w, h), d)
    Color.convert(zDepth, d, 20)
  end
end