defmodule Eager do
  def eval_expr({:atm, id}, env) do {:ok, id} end
  def eval_expr({:var, id}, env) do
    case Env.lookup(id, env) do
      nil ->
        :error
      {_, str} ->
        {:ok, str}
    end
  end
  def eval_expr({:cons, {t1_type, t1_val}, {t2_type, t2_val}}, env) do
    case eval_expr({t1_type, t1_val}, env) do
      :error ->
        :error
      {:ok, str} ->
        case eval_expr({t2_type, t2_val}, env) do
          :error ->
            :error
          {:ok, ts} ->
            {str, ts}
        end
    end
  end
end