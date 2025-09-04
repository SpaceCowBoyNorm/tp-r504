def puissance(a, b):
	try:
		if not type(a) is int or not type(b) is int:
			raise TypeError("Only integers are allowed")
	

		if a == 0 and b == 0:
			raise ValueError("0 puissance de 0 est définie")

		result_puissance = 1

		if b > 0:
			for _ in range(b):
				result_puissance *= a
		elif b < 0:
			for _ in range(-b):
				result_puissance *= a
			result_puissance = 1 / result_puissance


		return result_puissance

	except (TypeError, ValueError) as e:
		print(f"Exception attrapée : {e}")
		return None
