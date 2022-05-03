/*
 * Copyright 2020 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package tech.pegasys.teku.spec.datastructures.forkchoice;

import org.apache.tuweni.bytes.Bytes32;
import tech.pegasys.teku.infrastructure.unsigned.UInt64;
import tech.pegasys.teku.spec.datastructures.blocks.SignedBeaconBlock;
import tech.pegasys.teku.spec.datastructures.blocks.SignedBlockAndState;
import tech.pegasys.teku.spec.datastructures.blocks.SlotAndBlockRoot;
import tech.pegasys.teku.spec.datastructures.state.Checkpoint;
import tech.pegasys.teku.spec.datastructures.state.beaconstate.BeaconState;

public interface MutableStore extends ReadOnlyStore {

  void putBlockAndState(SignedBeaconBlock block, BeaconState state);

  default void putBlockAndState(SignedBlockAndState blockAndState) {
    putBlockAndState(blockAndState.getBlock(), blockAndState.getState());
  }

  void putStateRoot(Bytes32 stateRoot, SlotAndBlockRoot slotAndBlockRoot);

  void setTimeSeconds(UInt64 timeSeconds);

  void setTimeMillis(UInt64 timeMillis);

  void setGenesisTime(UInt64 genesisTime);

  void setJustifiedCheckpoint(Checkpoint justifiedCheckpoint);

  void setFinalizedCheckpoint(Checkpoint finalizedCheckpoint, boolean fromOptimisticBlock);

  void setBestJustifiedCheckpoint(Checkpoint bestJustifiedCheckpoint);

  void setProposerBoostRoot(Bytes32 boostedBlockRoot);

  void removeProposerBoostRoot();

  void removeFinalizedOptimisticTransitionPayload();
}
