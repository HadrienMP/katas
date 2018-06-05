package perso.woodyzuill;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class ItemNameGenerator extends Generator<ItemName> {
    public ItemNameGenerator() {
        super(ItemName.class);
    }

    @Override
    public ItemName generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        return sourceOfRandomness.choose(ItemName.values());
    }
}
