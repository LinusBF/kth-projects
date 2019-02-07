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
  def eval_expr({:cons, head, tail}, env) do
    case eval_expr(head, env) do
      :error ->
        :error
      {:ok, str} ->
        case eval_expr(tail, env) do
          :error ->
            :error
          {:ok, ts} ->
            {:ok, {str, ts}}
        end
    end
  end

  def eval_match(:ignore, _, env) do
    {:ok, env}
  end
  def eval_match({:atm, id}, id, env) do
    {:ok, env}
  end
  def eval_match({:var, id}, str, env) do
    case Env.lookup(id, env) do
      nil ->
        {:ok, Env.add(id, str, env)}
      {_, ^str} ->
        {:ok, env}
      {_, _} ->
        :fail
    end
  end
  def eval_match({:cons, [{:var , hp} | tp]}, {:cons, [{:atm, hq} | tq]}, env) do
    case eval_match({:var, hp}, hq, env) do
      :fail ->
        :fail
      {:ok, new_env} ->
        eval_match({:cons, tp}, {:cons, tq}, new_env)
    end
  end
  def eval_match({:cons, []}, {:cons, []}, env) do
    env
  end
  def eval_match(_, _, _) do
    :fail
  end
end