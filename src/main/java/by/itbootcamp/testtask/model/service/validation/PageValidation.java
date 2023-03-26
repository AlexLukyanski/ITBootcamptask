package by.itbootcamp.testtask.model.service.validation;

public class PageValidation {

    private final boolean isPageExist;

    public boolean isPageExist() {
        return isPageExist;
    }

    public PageValidation(PageValidationBuilder pageValidationBuilder) {
        this.isPageExist = pageValidationBuilder.isPageExist;
    }

    public boolean isPageValid() {
        return isPageExist;
    }

    public static class PageValidationBuilder {

        private boolean isPageExist;

        public PageValidationBuilder isPageExist(int page, int size, long userCount) {

            if (page < 0 || size <= 0 || userCount <= 0) {
                isPageExist = false;
                return this;
            }

            final int firstPageNumber = 0;
            int pagesAmount = (int) (userCount / size) + 1;

            if (page == firstPageNumber || (page > firstPageNumber && page <= pagesAmount)) {
                isPageExist = true;
            } else {
                isPageExist = false;
            }
            return this;
        }

        public PageValidation build() {
            return new PageValidation(this);
        }
    }
}
