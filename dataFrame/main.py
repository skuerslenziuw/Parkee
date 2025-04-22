import pandas as pd

# Gabungkan semua file CSV
files = ['branch_a.csv', 'branch_b.csv', 'branch_c.csv']
df_list = [pd.read_csv(file) for file in files]
df = pd.concat(df_list, ignore_index=True)

# Hapus baris dengan NaN di kolom penting
df.dropna(subset=['transaction_id', 'date', 'customer_id'], inplace=True)

# Ubah kolom date menjadi datetime
df['date'] = pd.to_datetime(df['date'])

# Hilangkan duplikat transaction_id, ambil data dengan tanggal terbaru
df.sort_values(by='date', ascending=False, inplace=True)
df = df.drop_duplicates(subset='transaction_id', keep='first')

# Hitung total penjualan = quantity * price
df['total'] = df['quantity'] * df['price']

# Hitung total penjualan per branch
sales_per_branch = df.groupby('branch')['total'].sum().reset_index()

# Simpan ke file CSV
sales_per_branch.to_csv('total_sales_per_branch.csv', index=False)

print("Data berhasil diproses dan disimpan ke total_sales_per_branch.csv")