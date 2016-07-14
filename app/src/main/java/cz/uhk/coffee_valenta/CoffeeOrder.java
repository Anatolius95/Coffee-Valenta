    package cz.uhk.coffee_valenta;

    import android.os.Bundle;
    import android.support.v7.app.ActionBarActivity;
    import android.view.View;
    import android.widget.CheckBox;
    import android.widget.TextView;

    import java.text.NumberFormat;

    public class CoffeeOrder extends ActionBarActivity {

        int NumberOfCoffees=0;
        int CoffeePrice=12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_order);
    }
        public void submitOrder(View view) {
            TextView priceTextView = (TextView) findViewById(
                    R.id.price_text_view);

            TextView priceHeadLineTextView = (TextView) findViewById(
                    R.id.PriceHeadLine_text_view);

            CheckBox milkCheck = (CheckBox) findViewById(
                    R.id.milk);

            CheckBox sugarCheck = (CheckBox) findViewById(
                    R.id.sugar);

            boolean milkB=milkCheck.isChecked();
            boolean sugarB=sugarCheck.isChecked();

            String milk = "";
            String sugar = "";

            if (milkB) {
                milk = "Yes";
                displayPrice(NumberOfCoffees * CoffeePrice);
                }else{
                    milk = "No";
                }

            if (sugarB) {
                sugar = "Yes";
                displayPrice(NumberOfCoffees * CoffeePrice);
                }else{
                    sugar = "No";
                }

            priceHeadLineTextView.setText("SUMMARY");
            priceTextView.setText("Amount: " + NumberOfCoffees + "\n Price: " + NumberOfCoffees * CoffeePrice + "$ \n Milk: " + milk + "\n Sugar: " + sugar);
            priceTextView.setTextSize(20);
        }
    public void submitOrderPlus(View view) {
        TextView priceTextView = (TextView) findViewById(
                R.id.price_text_view);
        TextView priceHeadLineTextView = (TextView) findViewById(
                R.id.PriceHeadLine_text_view);

        NumberOfCoffees = NumberOfCoffees + 1;
        display(NumberOfCoffees);
        displayPrice(NumberOfCoffees * CoffeePrice);
        priceTextView.setTextSize(40);
        priceHeadLineTextView.setText("PRICE");
    }
        public void submitOrderMinus(View view) {
            TextView priceTextView = (TextView) findViewById(
                    R.id.price_text_view);
            TextView priceHeadLineTextView = (TextView) findViewById(
                    R.id.PriceHeadLine_text_view);

            if (NumberOfCoffees < 1) {
                NumberOfCoffees = NumberOfCoffees + 1;
            }
            NumberOfCoffees = NumberOfCoffees - 1;
            display(NumberOfCoffees);
            displayPrice(NumberOfCoffees * CoffeePrice);
            priceTextView.setTextSize(40);
            priceHeadLineTextView.setText("PRICE");
        }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

        private void displayPrice(int number) {
            TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
            priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        }
}