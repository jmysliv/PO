package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.*;

public class ItemFilter {

	private Item itemSpec = new Item();

	private boolean hardcover;

	private boolean mobile;

	private boolean guarante;

	private boolean viedeo;

	public Item getItemSpec() {
		return itemSpec;
	}
	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (itemSpec.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (itemSpec.isPolish() && !item.isPolish()) {
			return false;
		}

		if (itemSpec.getCategory() == Category.BOOKS && item instanceof Book && this.hardcover && !((Book) item).isHardcover()) {
			return false;
		}

		if (itemSpec.getCategory() == Category.ELECTRONICS && item instanceof Electronics && this.mobile && !((Electronics) item).isMobile()) {
			return false;
		}

		if (itemSpec.getCategory() == Category.ELECTRONICS && item instanceof Electronics && this.guarante && !((Electronics) item).isGuarantee()) {
			return false;
		}

		if (itemSpec.getCategory() == Category.MUSIC && item instanceof Music && this.viedeo && !((Music) item).isVideo()) {
			return false;
		}


		return true;
	}

	public boolean isHardcover() {
		return hardcover;
	}

	public void setHardcover(boolean hardcover) {
		this.hardcover = hardcover;
	}

	public boolean isMobile() {
		return mobile;
	}

	public void setMobile(boolean mobile) {
		this.mobile = mobile;
	}

	public boolean isGuarante() {
		return guarante;
	}

	public void setGuarante(boolean guarante) {
		this.guarante = guarante;
	}

	public boolean isViedeo() {
		return viedeo;
	}

	public void setViedeo(boolean viedeo) {
		this.viedeo = viedeo;
	}
}